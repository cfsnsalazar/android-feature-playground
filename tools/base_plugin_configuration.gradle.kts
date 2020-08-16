apply {
    from("$rootDir/tools/test_instrumented.gradle")
    from("$rootDir/tools/test_unit.gradle")
    from("$rootDir/tools/flavor_config.gradle")
    from("$rootDir/tools/build_type_config.gradle")
    from("$rootDir/tools/coverage/jacoco.gradle")

}
