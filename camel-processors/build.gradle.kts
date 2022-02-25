@Suppress("UNCHECKED_CAST")
val libraryVersions = rootProject.extra.get("libraryVersions") as Map<String, String>

version = libraryVersions["idscp2"] ?: error("IDSCP2 version not specified")

dependencies {
    implementation("de.fhg.aisec.ids", "camel-idscp2", libraryVersions["idscp2"])

    implementation("de.fraunhofer.iais.eis.ids.infomodel", "java", libraryVersions["infomodel"])
    implementation("de.fraunhofer.iais.eis.ids", "infomodel-serializer", libraryVersions["infomodel"])

    implementation("org.apache.camel", "camel-core", libraryVersions["camel"])

    implementation("com.google.guava", "guava", libraryVersions["guava"]) {
        isTransitive = false // Avoid pulling in of checker framework and other annotation stuff
    }

    testImplementation("junit", "junit", libraryVersions["junit4"])
    testImplementation("org.apache.camel", "camel-test", libraryVersions["camel"])
    testImplementation("org.mockito", "mockito-core", libraryVersions["mockito"])
}