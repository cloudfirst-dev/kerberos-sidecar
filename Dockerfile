FROM registry.redhat.io/rhel8/httpd-24:latest

USER 0

RUN INSTALL_PKGS="mod_auth_gssapi" && \
    yum install -y --setopt=tsflags=nodocs $INSTALL_PKGS && \
    rpm -V $INSTALL_PKGS && \
    yum -y clean all --enablerepo='*'

ADD auth.conf /etc/httpd/conf.d/auth.conf

USER 1001

CMD ["/usr/bin/run-httpd"]