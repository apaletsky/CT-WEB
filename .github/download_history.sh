set -e

aws s3 ls ctwebtestreports | grep -v "fb-" | sort | tail -1 | awk '{print $2}' | xargs -I {} aws s3 cp --recursive s3://ctwebtestreports/allureReport/{}history $1/history
