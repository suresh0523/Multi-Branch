pipeline{
agent any
stages{
stage('scm')
{
steps{
git 'https://github.com/suresh0523/Multi-Branch.git'
}
}
stage('QG')
{
steps{
sh '/opt/maven/bin/mvn -Dmaven.test.failure.ignore clean verify'
}
}
}
}
