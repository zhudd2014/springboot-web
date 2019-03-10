#!/bin/bash

source /home/product/dubbo_framework/dubbo_shell/dubbo_init.sh

# timeout config , if application stop timeout force kill process
export STOP_TIMEOUT=10
# jvm memory config
export JAVA_MEM_OPTS="-server -Xms128m -Xmx128m -XX:SurvivorRatio=2 -XX:+UseParallelGC"

#use base_component_all
export USE_BASE_COMPONENT_ALL=1
