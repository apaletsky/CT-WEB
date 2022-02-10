set -e

aws s3 ls ctwebreports | grep -v "fb-" | sort | tail -1 | awk '{print $2}' | xargs -I {} aws s3 cp --recursive s3://ctwebreports/{}allure Report/history $1/history
