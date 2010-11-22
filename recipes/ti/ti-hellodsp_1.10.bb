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

PR = "r2"

PROVIDES += "ti-hellodsp-example"

require ti-hellodsp.inc
require ti-paths.inc
require ti-staging.inc
#require ti-eula-unpack.inc
require ../sd/sd-evmomapl137-bsl.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "da830-omapl137-evm"

S = "${WORKDIR}"

SRC_URI = " \
https://www-a.ti.com/downloads/sds_support/applications_packages/helloDSP/1_10/Linux/helloDSPgpp_1_10.tgz;name=hellogppgz \
https://www-a.ti.com/downloads/sds_support/applications_packages/helloDSP/1_10/Linux/helloDSPdsp_1_10.tgz;name=hellodspgz \
file://ti-hellodsp/0001-helloDSP-Makefiles.patch \
"

DEPENDS = "sd-evmomapl137-bsl"
DEPENDS += "ti-dsplink ti-dspbios"
DEPENDS += "ti-cgt6x virtual/kernel ti-xdctools"

PLATFORM_da830-omapl137-evm = "omapl137" 
 
BOARD_da830-omapl137-evm =  "evmOMAPL137"


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
    cd ${S}/helloDSPdsp
    make \
    PLATFORM="${PLATFORM}" \
    CSTOOL_DIR="${TOOLCHAIN_PATH}" \
    CSTOOLS_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
    LINUXKERNEL_INSTALL_DIR="{STAGING_KERNEL_DIR}" \
    BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}" \
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \
    LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
    BIOSPSP_INSTALL_DIR="${BIOSPSP_INSTALL_DIR}" \
    clean all 
}

do_install() {

    install -d ${D}${HELLODSP_INSTALL_DIR_RECIPE}

    install -d ${D}${HELLODSP_INSTALL_DIR_RECIPE}/Debug
    install -m 0755 ${S}/helloDSPdsp/Debug/helloDSP.out \
            ${D}${HELLODSP_INSTALL_DIR_RECIPE}/Debug/
    install -m 0755  ${S}/helloDSPgpp/Debug/helloDSPgpp \
            ${D}${HELLODSP_INSTALL_DIR_RECIPE}/Debug/

    install -d ${D}${HELLODSP_INSTALL_DIR_RECIPE}/Release
    install -m 0755 ${S}/helloDSPdsp/Release/helloDSP.out \
            ${D}${HELLODSP_INSTALL_DIR_RECIPE}/Release/
    install -m 0755 ${S}/helloDSPgpp/Release/helloDSPgpp \
            ${D}${HELLODSP_INSTALL_DIR_RECIPE}/Release/
}


PACKAGES += "ti-hellodsp-example"
FILES_ti-hellodsp-example += "${installdir}/ti-hellodsp-example/Debug/*"
FILES_ti-hellodsp-example += "${installdir}/ti-hellodsp-example/Release/*"
INSANE_SKIP_ti-hellodsp-example = "True"

RDEPENDS += "ti-dsplink-module"
