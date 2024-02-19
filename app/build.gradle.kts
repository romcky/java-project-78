plugins {
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
}

application {
    mainClass = "hexlet.code.App"
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }
    }
}


java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(20);
    }
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

