# Continuous Integration

The goal of the CI is to build at every push using Jenkins.

## Jenkins Setup

- Install [Jenkins](http://jenkins-ci.org/)
- Install the following plugins:

  - [Android Emulator](http://wiki.jenkins-ci.org/display/JENKINS/Android+Emulator+Plugin)
  - [Android Lint](https://wiki.jenkins-ci.org/display/JENKINS/Android+Lint+Plugin)
  - [Git Client](http://wiki.jenkins-ci.org/display/JENKINS/Git+Client+Plugin)
  - [Git](http://wiki.jenkins-ci.org/display/JENKINS/Git+Plugin)
  - [Gradle](http://wiki.jenkins-ci.org/display/JENKINS/Gradle+Plugin)
  - [JaCoCo](https://wiki.jenkins-ci.org/display/JENKINS/JaCoCo+Plugin)

## Project Setup

1. Create new freestyle project
2. Source Code Management:

   - Git
   - Put URL and credentials if necessary

3. Add build step #1 (**Invoke Gradle Script**):

   - Use Gradle Wrapper
   - Description: *Clean and compile*
   - Tasks: `clean testDebugClasses`

4. Add build step #2 (**Invoke Gradle Script**):

   - Use Gradle Wrapper
   - Description: *Build and test*
   - Tasks: `build`

5. Add post-build action (**Archive the artifacts**):

   - Archive the artifacts
   - Files to archive: `**/*.apk`

5. Add post-build action (**Record JaCoCo coverage report**):

   - Path to exec files: `**/**.exec`
   - Path to class directories: `**/classes/debug/com/example/android/app`
   - Path to source directories: `**/src/main/java`
   - Inclusions: *none*
   - Exclusions: `**/R.class, **/R$*.class, **/*$ViewInjector*.*, **/BuildConfig.*, **/Manifest*.*`

