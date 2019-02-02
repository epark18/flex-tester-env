#!/bin/bash

#### Constants

# set current working directory
	cwd=$(pwd)

# Create bundle folders
	mkdir -p bundles/7.1.x
	mkdir -p bundles/master
# Exceptions
	set -e

#### Functions


cleandb ()
{
	read -p "Enter database name [lportal]: " db_name
	db_name=${db_name:-lportal}
	echo -e "\e[44mOkay! I will drop $db_name and recreate it.\e[0m"
	mysql -e "DROP DATABASE if exists $db_name; create database $db_name character set utf8;"
}

createdb ()
{
	read -p "Enter database name [lportal]: " db_name
	db_name=${db_name:-lportal}
	echo -e "\e[44mOkay! I will drop $db_name and recreate it.\e[0m"
	mysql -e "create database $db_name character set utf8;"
}

dl71 ()
{
# Clean out old copy
	echo -e "\e[44mCleaning out old extracted binaries/folders\e[0m"
	rm -rf $cwd/7.1-ga3
	mkdir -p 7.1-ga3

# Check if 7.1-ga3 has already been downlaoded and if not, download it
	echo -e "\e[44mChecking if 7.1 GA3 was already downloaded\e[0m"

	DIRECTORY=$cwd/bundles/7.1.x/liferay-ce-portal-7.1.2-ga3
	if [[ -d "$DIRECTORY" ]]; then
		echo -e "\e[44mFound a copy of 7.1 GA3. Copying it to the working directory $cwd/7.1-ga3\e[0m"
	else
		echo -e "\e[44mDownloading the 7.1 GA3 because it wasn't found\e[0m"
		wget -c -N https://releases.liferay.com/portal/7.1.2-ga3/liferay-ce-portal-tomcat-7.1.2-ga3-20190107144105508.7z -P $cwd/bundles/7.1.x
		echo -e "\e[44mDone downloading or checking\e[0m"
# Extract the new bundle
		echo -e "\e[44mExtracting the 7.1 GA3 bundle\e[0m"
		7z x $cwd/bundles/7.1.x/liferay-ce-portal-tomcat-7.1.2-ga3-20190107144105508.7z -O$cwd/bundles/7.1.x
	fi
	echo -e "\e[44mCopying it over to the working directory [$cwd]/7.1-ga3\e[0m"
	cp -r $cwd/bundles/7.1.x/liferay-ce-portal-7.1.2-ga3/* $cwd/7.1-ga3
	echo -e "\e[44mCopying a basic portal-ext.properties over\e[0m"
	cp -r $cwd/resources/portal-ext.properties $cwd/7.1-ga3
	echo -e "\e[44mThe bundle is ready for testing.\e[0m"
	notify-send "The bundle is ready for testing!\e[0m"
}

dlmaster ()
{
# Clean out old copy
	echo -e "\e[44mCleaning out old extracted binaries/folders\e[0m"
	rm -rf $cwd/bundles/master/liferay-portal-master
	rm -rf $cwd/master

# Create directories that will be used
	echo -e "\e[44mCreating folders for bundle backup if they don't exist\e[0m"
	mkdir -p bundles/master
	mkdir -p master

# Check if a new master snapshot exists and download it
	echo -e "\e[44mDownloading the master snapshot if its updated\e[0m"
	wget -c -N https://releases.liferay.com/portal/snapshot-master/latest/liferay-portal-tomcat-master.7z -P $cwd/bundles/master
	echo -e "\e[44mDone downloading or checking\e[0m"


# Extract the new bundle
	echo -e "\e[44mExtracting the master bundle\e[0m"
	7z x $cwd/bundles/master/liferay-portal-tomcat-master.7z -O$cwd/bundles/master
	echo -e "\e[44mCopying it over to the working directory [$cwd]/master\e[0m"
	cp -r $cwd/bundles/master/liferay-portal-master/* $cwd/master
	echo -e "\e[44mCopying a basic portal-ext.properties over\e[0m"
	cp -r $cwd/resources/portal-ext.properties $cwd/master
	echo -e "\e[44mThe bundle is ready for testing."
	notify-send "The bundle is ready for testing!"
}

rstaging ()
{
# Clean out old copy
	echo -e "\e[44mCleaning out old extracted binaries/folders\e[0m"
	rm -rf $cwd/bundles/master/liferay-portal-master
	rm -rf $cwd/master
	rm -rf $cwd/master-staged
	rm -rf $cwd/master-live

# Create directories that will be used
	echo -e "\e[44mCreating folders for bundle backup if they don't exist\e[0m"
	mkdir -p bundles/master
	mkdir -p master-staged
	mkdir -p master-live

# Check if a new master snapshot exists and download it
	echo -e "\e[44mDownloading the master snapshot if its updated\e[0m"
	wget -c -N https://releases.liferay.com/portal/snapshot-master/latest/liferay-portal-tomcat-master.7z -P $cwd/bundles/master
	echo -e "\e[44mDone downloading or checking\e[0m"

# Extract the new bundle and make two copies
	echo -e "\e[44mExtracting the master bundle\e[0m"
	7z x $cwd/bundles/master/liferay-portal-tomcat-master.7z -O$cwd/bundles/master
	echo -e "\e[44mCopying it over to the working directory [$cwd]/master-staged\e[0m"
	cp -r $cwd/bundles/master/liferay-portal-master/* $cwd/master-staged
	echo -e "\e[44mCopying it over to the working directory [$cwd]/master-live\e[0m"
	cp -r $cwd/bundles/master/liferay-portal-master/* $cwd/master-live
	echo -e "\e[44mCopying properties for staged\e[0m"
	cp -r $cwd/resources/staged-ext.properties $cwd/master-staged
	echo -e "\e[44mCopying properties for staged\e[0m"
	cp -r $cwd/resources/live-ext.properties $cwd/master-live

# Replace server.xml on live
	echo -e "\e[44mReplacing server.xml on master-live.\e[0m"
	rm -rf $cwd/master-live/tomcat-9.0.10/conf/server.xml
	cp -r $cwd/resources/server.xml $cwd/master-live/tomcat-9.0.10/conf

# Preparing Databases master-staged and master-live
	echo -e "\e[44mPreparing databases master-staged and master-live\e[0m"
	mysql -e "DROP DATABASE if exists master_staged; create database master_staged character set utf8;"
	mysql -e "DROP DATABASE if exists master_live; create database master_live character set utf8;"

	echo -e "\e[44mThe bundle is ready for testing.\e[0m"
	notify-send "The bundle is ready for testing!"
}

#### Help documentation

usage ()
{
	cat <<HELP_USAGE


	$0 <parameter>

	Parameters
	----------

	cleandb            - Cleans the database if it already exists
	createdb           - Creates the database
	dl71               - Downloads the 7.1 CE GA3
	dlmaster           - Downloads the latest master
	rstaging           - Sets up remote staging where remote is 8080 and live is 9080


HELP_USAGE
}

#### Check if no parameters are sent

if [ $# -eq 0 ]
  then
    usage
fi

#### Accepts Parameters
$@