package org.msw.rawdeleter;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martin Swiech on 17.4.2016.
 */
public class Main {

    public static final String ORIG_EXTENSION = ".orig";
    public static final String RAW_EXTENSION = ".nef";
    public static final String JPG_EXTENSION = ".jpg";
    public static final String XMP_EXTENSION = ".nef.xmp";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("use direcrtory as an argument");
            return;
        }

        final String argDir = args[0];
        final Dirs dirs = getDirs(argDir);

        final Set<String> xmpLoweredNamesWithoutExtension = getLoweredXmpNamesWithoutExtension(dirs.getProcessedDir());
        xmpLoweredNamesWithoutExtension.addAll(getLoweredXmpNamesWithoutExtension(dirs.getOrigDir()));
        System.out.println("XMPs: " + xmpLoweredNamesWithoutExtension);

        deleteFilesWithoutXmp(dirs.getOrigDir(), xmpLoweredNamesWithoutExtension, RAW_EXTENSION);
        deleteFilesWithoutXmp(dirs.getOrigDir(), xmpLoweredNamesWithoutExtension, JPG_EXTENSION);
    }

    public static void deleteFilesWithoutXmp(final File dir, Set<String> xmpNamesWithoutExtension, final String extension) {
        final File[] list = dir.listFiles();
        if (list != null) {
            for (final File file : list) {
                if (file.isFile()) {
                    final String completeName = file.getName();
                    final String[] nameAndExtension = getNameAndExtension(completeName, extension);
                    if (nameAndExtension != null && !xmpNamesWithoutExtension.contains(nameAndExtension[0].toLowerCase())) {
                        System.out.println("deleting file " + file.getAbsolutePath());
                        file.delete();
                    }
                }
            }
        }
    }

    public static Set<String> getLoweredXmpNamesWithoutExtension(final File dir) {
        final Set<String> result = new HashSet<String>();
        final File[] list = dir.listFiles();
        if (list != null) {
            for (final File file : list) {
                if (file.isFile()) {
                    final String completeName = file.getName();
                    final String[] nameAndExtension = getNameAndExtension(completeName, XMP_EXTENSION);
                    if (nameAndExtension != null) {
                        result.add(nameAndExtension[0].toLowerCase());
                    }
                }

            }
        }
        return result;
    }

    public static Dirs getDirs(final String argDir) {
        final File argDirFile = new File(argDir).getAbsoluteFile();
        if (!argDirFile.exists() || !argDirFile.isDirectory()) {
            throw new RawDeleterException(argDirFile.getAbsolutePath() + " does not exists or is not directory.");
        }

        final String argDirFileName = argDirFile.getName();
        final String[] nameAndExtension = getNameAndExtension(argDirFileName, ORIG_EXTENSION);
        if (nameAndExtension != null) {
            final File processingDir = new File(argDirFile.getParent(), nameAndExtension[0]);
            if (!processingDir.exists() || !processingDir.isDirectory()) {
                throw new RawDeleterException(processingDir.getAbsolutePath() + " does not exists or is not directory.");
            }
            return new Dirs(argDirFile, processingDir);
        }

        final File origDir = new File(argDirFile.getParent(), argDirFileName + ORIG_EXTENSION);
        if (!origDir.exists() || !origDir.isDirectory()) {
            throw new RawDeleterException(origDir.getAbsolutePath() + " does not exists or is not directory.");
        }
        return new Dirs(origDir, argDirFile);
    }

    public static String[] getNameAndExtension(final String completeName, final String expectedExtension) {
        if (completeName.length() > expectedExtension.length()) {
            final String name = completeName.substring(0, completeName.length() - expectedExtension.length());
            final String extension = completeName.substring(completeName.length() - expectedExtension.length());
            if (expectedExtension.equalsIgnoreCase(extension)) {
                return new String[] {name, extension};
            }
        }
        return null;
    }


}
