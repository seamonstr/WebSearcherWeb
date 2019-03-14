#!/bin/bash

echo '*******************************************************'
echo Starting GoogleSearcherWeb service
echo '*******************************************************'
usage()
{
    echo "Specify -d to enable debugging port on the jvm, port 5005 "
}

while [ "$1" != "" ]; do
    case $1 in
        -d | --debug )          if [ "$#" -gt 0 ]; then shift; fi
                                debug="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
                                ;;
        * )                     usage
                                exit 1
    esac
    shift
done

java $debug -jar /usr/local/GoogleSearcherWeb/service.jar
