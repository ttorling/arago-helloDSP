DESCRIPTION = "TI HelloDSP example application \
ARM side"
HOMEPAGE = "https://www-a.ti.com/downloads/sds_support/applications_packages/helloDSP/index.htm"
SECTION = "software development"

PV = "1_10"
PVwithDots = "1.10"

SRC_URI[hellogppgz.md5sum] = "79c95dae70d5651e5eba824c7343f8c6"
SRC_URI[hellogppgz.sha256sum] = "c48e4d8634ae5689e976625c30dc6af2b53ccb65391f0722a8499cecd2f10739"

PR = "r1"

require hellodsp.inc
#require ti-paths.inc
#require ti-staging.inc
#require ti-eula-unpack.inc

S = "${WORKDIR}/hellodsp-gpp-${PV}"

SRC_URI = "https://www-a.ti.com/downloads/sds_support/applications_packages/helloDSP/1_10/Linux/helloDSPgpp_1_10.tgz;name=hellogppgz"




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





