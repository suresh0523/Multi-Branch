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
  stage('Build')
{
steps{
sh '/opt/maven/bin/mvn -Dmaven.test.failure.ignore clean install'
}
}

    stage('Update Version')

{
steps{
sh '/opt/maven/bin/mvn versions:set -DnewVersion=1.0.3-SNAPSHOT'
  sh 'git add pom.xml'
  sh' git remote set-url origin git@github.com:suresh0523/Multi-Branch.git'
  sh 'git commit -m "updated pom.xml"'
  sh 'git push origin dev'



}
}
}
}
