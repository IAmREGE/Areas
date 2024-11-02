version = "0.0.1-a.1"
group = "rege.rege.areas"

plugins {
    application
}

dependencies {
    compileOnly("org.jetbrains:annotations-java5:24.1.0")
}

base {
    archivesName = "areas"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_5
    targetCompatibility = JavaVersion.VERSION_1_5
    withSourcesJar()
    withJavadocJar()
}
