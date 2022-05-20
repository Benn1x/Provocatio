plugins {
    kotlin("jvm") version "1.6.10"
    id("io.papermc.paperweight.userdev") version "1.3.5"
    id("xyz.jpenilla.run-paper") version "1.0.6"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "main"
version = "1.0.0"

repositories {
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/") {
        name = "sonatype-oss-snapshots"
    }
    mavenCentral()
}

dependencies {
    paperDevBundle("1.18.2-R0.1-SNAPSHOT")
    implementation("net.axay:kspigot:1.18.0")
    implementation("net.kyori:adventure-api:4.10.1")
    implementation("net.kyori:adventure-text-minimessage:4.10.1")
}

tasks {
    assemble {
        dependsOn(reobfJar)
        dependsOn(shadowJar)
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(17)
    }
    shadowJar{
        relocate("net.kyori.adventure.text.minimessage","com.daskju.shadow.adventure")
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}
tasks {
    runServer {
        minecraftVersion("1.18.2")
    }
}