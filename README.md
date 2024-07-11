# Tai

Tai, meaning to-do in Japanese, is a todo app which is built upon Quarkus and ReactJS.

![](https://i.imgur.com/5UXfv9n.png)

# How to use

## Run the native executable

```shell
./Tai-1.0.0-runner
```

## Build your own using Quarkus CLI

### Install SDKMAN:

```shell
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

### Install GraalVM

```shell
sdk install java 22.0.1-graal
sdk use java 22.0.1-graal
```

### Install Quarkus

```shell
sdk install quarkus
```

### Build the native executable at the root directory of the project

```shell
quarkus build --native
```

### Launch the app

```shell
./target/Tai-1.0.0-runner
```

