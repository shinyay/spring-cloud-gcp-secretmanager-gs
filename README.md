# Spring Cloud GCP for Secret Manager

Secret Manager stores API keys, passwords, certificates, and other sensitive data.

## Description
### Dependency
- com.google.cloud
  - `spring-cloud-gcp-starter-secretmanager`

### Secret Manager Overview

Secret Manager stores user's data with **Secret Name** and **Secret Version**

- Secret
  - Version 1 <- Store Data
  - Version 2 <- Store Data

## Demo
### Configure Secret Manager
#### Enable Secret Manager API
```shell script
$ gcloud services enable secretmanager.googleapis.com
```

#### Create Secret
```shell script
$ echo -n "Secret Manager Demo" | \
    gcloud secrets create app-secret \
    --data-file=- --replication-policy=automatic

Created version [1] of the secret [app-secret].
```

##### List Secret
```shell script
$ gcloud secrets list
```

##### Delete Secret
```shell script
$ gcloud secrets delete app-secret
```

##### List Versions in Secret
```shell script
$ gcloud secrets versions list app-secret

NAME  STATE    CREATED              DESTROYED
1     enabled  2021-01-12T05:00:09  -
```

##### Disable / Enable Version
```shell script
$ gcloud secrets versions disable 1 --secret app-secret
$ gcloud secrets versions enable 1 --secret app-secret
```

### Secret Manager Property Source
#### 1. Long form - specify the project ID, secret ID, and version
```
sm://projects/<project-id>/secrets/<secret-id>/versions/<version-id>}
```

#### 2.  Long form - specify project ID, secret ID, and use latest version
```
sm://projects/<project-id>/secrets/<secret-id>
```

#### 3. Short form - specify project ID, secret ID, and version
```
sm://<project-id>/<secret-id>/<version-id>
```

#### 4. Short form - default project; specify secret + version
The project is inferred from the spring.cloud.gcp.secretmanager.project-id setting in your `bootstrap.yml` or `Google Application Default Credentials (ADC)`.
```
sm://<secret-id>/<version>
```

#### 5. Shortest form - specify secret ID, use default project and latest version.
```
sm://<secret-id>
```

### Enable / Disable Secret Manager
You can configure enable/disable at property:

```yaml
spring:
  cloud:
    gcp:
      secretmanager:
        enabled: [true / false]
```

#### Spring Profiles
You can switch configuration with Spring Profiles.

Specify profile at the following property:

- `spring.config.activate.on-profile`

```yaml
spring:
  profiles:
    include: prod
---
spring:
  config:
    activate:
      on-profile: prod
  cloud:
    gcp:
      secretmanager:
        enabled: true
my-app:
  my-env:
    secretmanager: ${sm://app-secret}
---
spring:
  config:
    activate:
      on-profile: dev
  cloud:
    gcp:
      secretmanager:
        enabled: false
my-app:
  my-env:
    secretmanager: "Offline"
``` 

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
