package org.msw.rawdeleter;

import java.io.File;

/**
 * Created by Martin Swiech on 17.4.2016.
 */
public class Dirs {

    private final File origDir;

    private final File processedDir;

    public Dirs(final File origDir, final File processedDir) {
        this.origDir = origDir;
        this.processedDir = processedDir;
    }

    public File getOrigDir() {
        return origDir;
    }

    public File getProcessedDir() {
        return processedDir;
    }

    @Override
    public String toString() {
        return "Dirs{" +
                "origDir=" + origDir +
                ", processedDir=" + processedDir +
                '}';
    }
}
