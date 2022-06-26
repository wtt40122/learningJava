//写流水线的脚本（声明式、脚本式）
pipeline{
    //全部的CICD流程都需要在这里定义

    //任何一个代理可用就可以执行
    // agent none  //以后所有stage都必须指定自己的
    agent any

    environment {
        hello = "123456"
        world = "456789"
        WS = "${WORKSPACE}"
        IMAGE_VERSION = "v1.0"

        //引用Jenkins配置的全局秘钥信息
        ALIYUN_SECRTE=credentials("aliyun-docker-repo")
    }

    //定义流水线的加工流程
    stages {
        //流水线的所有阶段
        stage('环境检查'){
            steps {
                sh 'printenv'
                echo "正在检测基本信息"
                sh 'java -version'
                sh 'git --version'
                sh 'docker version'
                sh 'pwd && ls -alh'
                sh "echo $hello"
                //未来，凡是需要取变量值的时候，都用双引号
                sh 'echo ${world}'
                sh "ssh --help"
            }
        }
    }


}