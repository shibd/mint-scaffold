projectDir = new File(new File(request.outputDirectory), request.artifactId)

/**
 * 在projectDir目录下运行命令
 * @param cmd
 * @return
 */
def run(String cmd) {
    def process = cmd.execute(null, projectDir)
    process.waitForProcessOutput((Appendable) System.out, System.err)
    if (process.exitValue() != 0) {
        process.
                throw new Exception("Command '$cmd' exited with code: ${process.exitValue()}")
    }
}

/**
 * 设置文件的可执行权限
 * @param fileDir
 * @return
 */
def setExecutable(String fileDir) {
    def deployMaven = new File(projectDir, fileDir)
    println "file set executable:" + deployMaven
    deployMaven.setExecutable(true, false)
}

// 设置文件可执行权限
setExecutable("/tools/deploy-maven")
setExecutable("/tools/upgrade-version")
setExecutable("/tools/mybatis-generator")
setExecutable("/tools/build-startup")
setExecutable("/tools/build-startup-docker")

// 运行代码格式化插件
run("mvn spring-javaformat:apply")

// 运行git init
run("git init")
run("git add .")
run("git commit -m \"init\"")

print "\n" +
        "              _           _   \n" +
        "  _ __ ___   (_)  _ __   | |_ \n" +
        " | '_ ` _ \\  | | | '_ \\  | __|\n" +
        " | | | | | | | | | | | | | |_ \n" +
        " |_| |_| |_| |_| |_| |_|  \\__|\n" +
        " Mint Scaffold:(v3.2-SNAPSHOT) \n\n"
