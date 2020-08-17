# Kerberos Sidecar Proxy
This repository demonstrates securing a pod with a sidecar that can perform challenge authentication with kerberos

![Architecture Diagram](docs/arch-diagram.jpg)

## Prerequisites
* Computer bound to an Active Directory
* Keytab as an HTTP service principal
* Service account created to bind to the HTTP Kerberos Principal

### Generate Service Keytab
1. on a windows machine generate the keytab with
    ```

    ```
1. Save the keytab file to helm/files/krb5.keytab

## Install
1. From the root directory execute, replacing with your host you defined in your keytab creation
    ```
    helm install sso-proxy helm --set route.host=(host used from keytab above)
    ```

## Validate
1. Go to the address http://(host used from keytab above)/hi
1. You should see the currently logged in user's principal (ex. user@MY.DOMAIN.EXAMPLE.COM)