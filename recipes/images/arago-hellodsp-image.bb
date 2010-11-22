# Arago helloDSP image
# gives you an image with helloDSP example and DVSDK libs

require arago-image.inc

COMPATIBLE_MACHINE = "da830-omapl137-evm"

# The size of the uncompressed ramdisk is 100MB
ROOTFS_SIZE = "102400"

IMAGE_INSTALL += "\
    task-arago-base \
    task-arago-console \
    task-arago-dvsdk \
    task-arago-hellodsp \
    "

PACKAGE_INSTALL += "\
    ti-dsplink-examples \
    ti-hellodsp-example \
    "
export IMAGE_BASENAME = "arago-hellodsp-image"
