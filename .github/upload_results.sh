set -e

version=$(date "+%Y%m%d-%H%M%S")
current_branch=$(git branch 2>/dev/null | grep '^*' | colrm 1 2)
if [ "$current_branch" != "master" ]
then
version="fb-"$version
fi
aws s3 sync $1 "s3://ctwebreports/$version"
echo "::warning::See report: http://ctwebreports.s3-website-eu-west-1.amazonaws.com/$version/allureReport/index.html"
echo "REPORT_URL=http://ctwebreports.s3-website-eu-west-1.amazonaws.com/$version/allureReport/index.html" >> $GITHUB_ENV
