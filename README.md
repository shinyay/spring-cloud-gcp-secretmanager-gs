# Spring Cloud GCP for Secret Manager

Secret Manager stores API keys, passwords, certificates, and other sensitive data.

## Description
### Dependency
- com.google.cloud
  - `spring-cloud-gcp-starter-secretmanager`

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
```

##### List Secret
```shell script
$ gcloud secrets list
```

#### Delete Secret
```shell script
$ gcloud secrets delete app-secret
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
