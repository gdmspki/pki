project(pki-tps_java NONE)

find_file(LDAPJDK_JAR
    NAMES
        ldapjdk.jar
    PATHS
        /usr/share/java
)

find_file(JSS_JAR
    NAMES
        jss4.jar
    PATHS
        ${JAVA_LIB_INSTALL_DIR}
)

find_file(COMMONS_CODEC_JAR
    NAMES
        commons-codec.jar
    PATHS
        /usr/share/java
)

find_file(PKI_CERTSRV_JAR
    NAMES
        pki-certsrv.jar
    PATHS
        /usr/share/java/pki
)

find_file(PKI_CMS_JAR
    NAMES
        pki-cms.jar
    PATHS
        /usr/share/java/pki
)

find_file(PKI_CMSCORE_JAR
    NAMES
        pki-cmscore.jar
    PATHS
        /usr/share/java/pki
)

find_file(PKI_CMSUTIL_JAR
    NAMES
        pki-cmsutil.jar
    PATHS
        /usr/share/java/pki
)

find_file(PKI_NSUTIL_JAR
    NAMES
        pki-nsutil.jar
    PATHS
        /usr/share/java/pki
)

find_file(RESTEASY_JAXRS_JAR
    NAMES
        resteasy-jaxrs.jar
    PATHS
        ${RESTEASY_LIB}
)

find_file(RESTEASY_ATOM_PROVIDER_JAR
    NAMES
        resteasy-atom-provider.jar
    PATHS
        ${RESTEASY_LIB}
)

find_file(SYMKEY_JAR
    NAMES
        symkey.jar
    PATHS
        ${JAVA_LIB_INSTALL_DIR}
        /usr/share/java
)

find_file(VELOCITY_JAR
    NAMES
        velocity.jar
    PATHS
        ${JAVA_LIB_INSTALL_DIR}
        /usr/share/java
)

# build pki-tps
javac(pki-tps-classes
    SOURCES
        *.java
    CLASSPATH
        ${COMMONS_CODEC_JAR} ${COMMONS_LANG_JAR}
        ${LDAPJDK_JAR}
        ${JSS_JAR} ${SYMKEY_JAR}
        ${JAXRS_API_JAR} ${RESTEASY_JAXRS_JAR} ${RESTEASY_ATOM_PROVIDER_JAR}
        ${SERVLET_JAR} ${TOMCAT_CATALINA_JAR} ${VELOCITY_JAR}
        ${PKI_CMSUTIL_JAR} ${PKI_NSUTIL_JAR}
        ${PKI_CERTSRV_JAR} ${PKI_CMS_JAR} ${PKI_CMSCORE_JAR}
    OUTPUT_DIR
        ${CMAKE_CURRENT_BINARY_DIR}/classes
    DEPENDS
        symkey-jar pki-nsutil-jar pki-cmsutil-jar pki-certsrv-jar pki-cms-jar pki-cmscore-jar
)

configure_file(
    ${CMAKE_CURRENT_SOURCE_DIR}/pki-tps.mf
    ${CMAKE_CURRENT_BINARY_DIR}/pki-tps.mf
)

jar(pki-tps-jar
    CREATE
        ${CMAKE_BINARY_DIR}/dist/pki-tps.jar
    OPTIONS
        m
    PARAMS
        ${CMAKE_CURRENT_BINARY_DIR}/pki-tps.mf
    INPUT_DIR
        ${CMAKE_CURRENT_BINARY_DIR}/classes
    DEPENDS
        pki-tps-classes
)

install(
    FILES
        ${CMAKE_BINARY_DIR}/dist/pki-tps.jar
    DESTINATION
        ${JAVA_JAR_INSTALL_DIR}/pki
)

set(PKI_TPS_JAR ${CMAKE_BINARY_DIR}/dist/pki-tps.jar CACHE INTERNAL "pki-tps jar file")
