DESCRIPTION = "TI HelloDSP example application \
DSP side"
HOMEPAGE = "https://www-a.ti.com/downloads/sds_support/applications_packages/helloDSP/index.htm"
SECTION = "software development"
LICENSE = "TI"

PV = "1_10"
PVwithDots = "1.10"

SRC_URI[hellodspgz.md5sum] = "3ed3454a7446471cdb66be044f4e4fea"
SRC_URI[hellodspgz.sha256sum] = "0cc97bcd3564d54e99b4bd9ddbf9afb004ff1c673853731815416da619596d9b"

PR = "r1"

require hellodsp.inc
#require ti-paths.inc
#require ti-staging.inc
#require ti-eula-unpack.inc

S = "${WORKDIR}/hellodsp-dsp-${PV}"

SRC_URI = "https://www-a.ti.com/downloads/sds_support/applications_packages/helloDSP/1_10/Linux/helloDSPdsp_1_10.tgz;name=hellodspgz"


do_prepsources() {
    echo "Do Nothing for Now" 
}

addtask prepsources after do_configure before do_compile

do_compile() {
    echo "Do Nothing for Now"
}

do_install() {

    install -d ${D}${HELLODSP_INSTALL_DIR_RECIPE}
}





