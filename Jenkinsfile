pipeline {
    agent any
    
    stages {
        stage('Checkout Code') {
            steps {
                script {
                    deleteDir()
                    checkout([$class: 'GitSCM', 
                        branches: [[name: '*/main']], 
                        doGenerateSubmoduleConfigurations: false, 
                        extensions: [], 
                        submoduleCfg: [], 
                        userRemoteConfigs: [[url: 'https://github.com/nikakokhreidze19/designPatterns_homework.git']]
                    ])
                }
            }
        }

        stage('Run Maven Project') {
            steps {
                script {
                    bat 'mvn clean test'
                }
            }
        }

        stage('Get Maven Version') {
            steps {
                script {
                    bat 'mvn --version'
                }
            }
        }
    }
}
