DESCRIPTION = "Extended task to add helloDSP components"
LICENSE = "TI"
PR = "r1"

inherit task
PACKAGE_ARCH = "${MACHINE_ARCH}"

HELLODSP_COMPONENTS ?= ""
HELLODSP_COMPONENTS_da830-omapl137-evm += "ti-dsplink-examples"
HELLODSP_COMPONENTS_da830-omapl137-evm += "ti-hellodsp-example"

RDEPENDS_${PN} = "\
    ${HELLODSP_COMPONENTS} \
    "

RRECOMMENDS_${PN} = "\
    kernel-modules \
    "
