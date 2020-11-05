#!/bin/bash
ENV=${1:-local}

sbt -Denvironment=$ENV "testOnly uk.gov.hmrc.test.ui.cucumber.runner.ApiRunner"
