sdinstalldir = "${datadir}/sd"

# This is where do_install will put it
export EVMOMAPL_BSL_INSTALL_DIR_RECIPE  = "${sdinstalldir}/sd-evmomapl137-bsl-tree"
export EVMOMAPL_BSL_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${EVMOMAPL_BSL_INSTALL_DIR_RECIPE}"
export EVMOMAPL_BSL_SOURCE_DIR = "${sdinstalldir}/sd-evmomapl137-bsl-tree/"
