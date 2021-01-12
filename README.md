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
