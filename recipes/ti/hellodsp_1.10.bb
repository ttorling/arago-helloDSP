DESCRIPTION = "TI HelloDSP example application"
HOMEPAGE = "https://www-a.ti.com/downloads/sds_support/applications_packages/helloDSP/index.htm"
SECTION = "devel"
LICENSE = "TI"

PV = "1_10"
PVwithDots = "1.10"

SRC_URI[hellogppgz.md5sum] = "79c95dae70d5651e5eba824c7343f8c6"
SRC_URI[hellogppgz.sha256sum] = "c48e4d8634ae5689e976625c30dc6af2b53ccb65391f0722a8499cecd2f10739"
SRC_URI[hellodspgz.md5sum] = "3ed3454a7446471cdb66be044f4e4fea"
SRC_URI[hellodspgz.sha256sum] = "0cc97bcd3564d54e99b4bd9ddbf9afb004ff1c673853731815416da619596d9b"

PR = "r7"

require hellodsp.inc
require ti-paths.inc
#require ti-staging.inc
#require ti-eula-unpack.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(da830-omapl137-evm|da850-omapl138-evm)"

S = "${WORKDIR}"

SRC_URI = "https://www-a.ti.com/downloads/sds_support/applications_packages/helloDSP/1_10/Linux/helloDSPgpp_1_10.tgz;name=hellogppgz \
file://helloDSP/0001-helloDSPgpp-Makefile.patch \
https://www-a.ti.com/downloads/sds_support/applications_packages/helloDSP/1_10/Linux/helloDSPdsp_1_10.tgz;name=hellodspgz"

DEPENDS = "ti-dsplib-c674"
DEPENDS += "ti-dsplink ti-dspbios ti-biospsp"
DEPENDS += "ti-cgt6x virtual/kernel ti-xdctools"

PLATFORM_da830-omapl137-evm = "omapl137" 
PLATFORM_da850-omapl138-evm = "omapl138" 
 
BOARD_da830-omapl137-evm =  "evmOMAPL137"
BOARD_da850-omapl138-evm =  "evmOMAPL138"


do_prepsources() {
    echo "Do Nothing for Now" 
}

addtask prepsources after do_configure before do_compile

do_compile() {
	echo ${TOOLCHAIN_PATH}
    # Build gpp sample application
    cd ${S}/helloDSPgpp
    make \
    PLATFORM="${PLATFORM}" \
    CSTOOL_DIR="${TOOLCHAIN_PATH}" \
    CSTOOLS_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
    CC="../${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}gcc" \
    LINUXKERNEL_INSTALL_DIR="{STAGING_KERNEL_DIR}" \
    BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}" \
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \
    LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
    BIOSPSP_INSTALL_DIR="${BIOSPSP_INSTALL_DIR}" \
    clean all

    # Build dsp sample application
    #make \
    #PLATFORM="${PLATFORM}" \
    #CSTOOL_DIR="${TOOLCHAIN_PATH}" \
    #CSTOOLS_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
    #LINUXKERNEL_INSTALL_DIR="{STAGING_KERNEL_DIR}" \
    #BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}" \
    #XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    #CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \
    #LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
    #BIOSPSP_INSTALL_DIR="${BIOSPSP_INSTALL_DIR}" \
    #EDMA3LLD_INSTALL_DIR="${EDMA3_LLD_INSTALL_DIR}" \
    #dsp 
}

do_install() {

    install -d ${D}${HELLODSP_INSTALL_DIR_RECIPE}
}





