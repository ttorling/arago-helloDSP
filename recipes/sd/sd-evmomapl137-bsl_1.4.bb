DESCRIPTION = "Spectrum Digital EVM OMAPL137 BSL Rev D"
HOMEPAGE = "http://support.spectrumdigital.com/evmomapl137/revd/"
SECTION = "devel"
LICENSE = "SD"

PV = "1_4"
PVwithDots = "1.4"

SRC_URI[evmbslzip.md5sum] = "69b4a2d2265145afcc91dd06e83b94b5"
SRC_URI[evmbslzip.sha256sum] = "f0a378325ac9df3a8fe290692fe660a7883bdaf33d6f2b317f958f94c5b5897b"

PR = "r5"

require sd-evmomapl137-bsl.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "da830-omapl137-evm"

S = "${WORKDIR}"

SRC_URI = " \
http://support.spectrumdigital.com/boards/evmomapl137/revd/files/RevD_EVMOMAPL137_BSL.zip;name=evmbslzip \
"

PLATFORM_da830-omapl137-evm = "omapl137" 
 
BOARD_da830-omapl137-evm =  "evmOMAPL137"


do_prepsources() {
    echo "Do Nothing for Now" 
}

addtask prepsources after do_configure before do_compile

do_compile() {
    cd ${S}
}

do_install() {
    install -d ${D}${EVMOMAPL_BSL_INSTALL_DIR_RECIPE}
}

do_stage() {
    echo ${STAGING_DIR}
    echo ${EVMOMAPL_BSL_INSTALL_DIR}
    install -d ${EVMOMAPL_BSL_INSTALL_DIR}
    cp -pPrf ${S}/evm* ${EVMOMAPL_BSL_INSTALL_DIR}
}


FILES_${PN} += "${installdir}/sd-evmomapl137-bsl/*"
PACKAGE_STRIP = "no"
INSANE_SKIP_${PN} = "True"
