//写流水线的脚本（声明式、脚本式）
pipeline{
    //全部的CICD流程都需要在这里定义

    //任何一个代理可用就可以执行
    // agent none  //以后所有stage都必须指定自己的
    agent any


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
        //1、编译 "abc"
        stage('maven编译'){
            //jenkins不配置任何环境的情况下， 仅适用docker 兼容所有场景
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /var/jenkins_home/appconfig/maven/.m2:/root/.m2'
//                     args  '-v /a/settings.xml:/app/settings.xml'
                    //docker run -v /a/settings.xml:/app/settings.xml
                }
            }
            steps {
                //git下载来的代码目录下
                sh 'pwd && ls -alh'
                sh 'mvn -v'
                //打包，jar.。默认是从maven中央仓库下载。 jenkins目录+容器目录；-s指定容器内位置
                //只要jenkins迁移，不会对我们产生任何影响
                sh "echo 默认的工作目录：${WS}"
//                sh 'cd ${WS}'
                //workdir
                //每一行指令都是基于当前环境信息。和上下指令无关
                sh 'cd ${WS} && mvn clean package -s "/var/jenkins_home/appconfig/maven/settings.xml"  -Dmaven.test.skip=true '
                //jar包推送给maven repo ，nexus
                //如何让他适用阿里云镜像源

            }
        }

        //2、测试，每一个 stage的开始，都会重置到默认的WORKSPACE位置
        stage('测试'){
            steps {
                sh 'pwd && ls -alh'
                echo "测试..."
            }
        }

        //3、打包
        stage('生成镜像'){
            steps {
                echo "打包..."
                //检查Jenkins的docker命令是否能运行
                sh 'docker version'
                sh 'pwd && ls -alh'
                sh 'docker build -t java-devops-demo .'

                //镜像就可以进行保存


            }
        }

        //4、部署
        stage('部署'){
            steps {
                echo "部署..."
                sh 'docker rm -f java-devops-demo-dev'
                sh 'docker run -d -p 8888:8080 --name java-devops-demo-dev java-devops-demo'
            }

            //后置执行
//             post {
//               failure {
//                 // One or more steps need to be included within each condition's block.
//                 echo "炸了.. ."
//               }
//
//               success {
//                 echo "成了..."
//               }
//             }
        }

        stage('部署到生产环境吗？'){
            steps {
                // 手动输入版本【参数化构建】,推荐生成器

//                 input {
//                     message "需要部署到生产环境吗?"
//                     ok "是的，赶紧部署"
// //                     submitter "alice,bob"
//                     parameters {
//                         //手动传入的参数
//                         string(name: 'APP_VERSION', defaultValue: 'v1.0', description: '请指定生产版本号')
//                     }
//                 }
                sh "echo 发布版本咯......"
                // 版本的保存。代码的保存。镜像的保存。存到远程仓库

            }
        }

    }


}