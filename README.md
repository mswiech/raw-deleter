## RAW deleter

Simple command line util for cleaning unused RAW files stored from my Nikon camera.

### Usage:

`java -jar raw-deleter.jar directory`

### Explain:

It expect two directories:

* fooNameDirectoryName - processed pictures files ( `.nef.xmp` files)
* fooNameDirectoryName.orig - orig camera files directory ( `.jpg` a `.nef` files)

This util scan for `.nef.xmp` files and then delete those `.jpg` and `.nef` files from `.orig` directory, which has not `.nef.xmp` couple.

### WARNING

This util is for deleting files. If you want to use it, do some backup first.
> Better safe than sorry.
