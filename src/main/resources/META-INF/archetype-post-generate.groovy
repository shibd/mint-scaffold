// 设置脚本可执行权限
def deployMaven = new File( request.getOutputDirectory(), request.getArtifactId() + "/tools/deploy-maven")
println "deploy-maven file path:" + deployMaven
deployMaven.setExecutable(true, false)

def upgradeVersion = new File( request.getOutputDirectory(), request.getArtifactId() + "/tools/upgrade-version")
println "upgrade-version file path:" + upgradeVersion;
upgradeVersion.setExecutable(true, false)

def mybatisGenerator = new File( request.getOutputDirectory(), request.getArtifactId() + "/tools/mybatis-generator")
println "mybatis-generator file path:" + mybatisGenerator;
mybatisGenerator.setExecutable(true, false)

def buildStartup = new File( request.getOutputDirectory(), request.getArtifactId() + "/tools/build-startup")
println "build-startup file path:" + buildStartup;
buildStartup.setExecutable(true, false)

print   "\n" +
        "              _           _   \n" +
        "  _ __ ___   (_)  _ __   | |_ \n" +
        " | '_ ` _ \\  | | | '_ \\  | __|\n" +
        " | | | | | | | | | | | | | |_ \n" +
        " |_| |_| |_| |_| |_| |_|  \\__|\n" +
        "  Mint Scaffold:(v3.2-SNAPSHOT) \n\n"
