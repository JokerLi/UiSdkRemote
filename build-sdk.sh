curr=$(pwd)
rm -r build/
if gradle assembleRelease
then
    mkdir -p build/sdk/tmp
    cp build/intermediates/bundles/release/classes.jar  build/sdk/tmp/
    cp build/intermediates/bundles/release/libs/*.jar build/sdk/tmp
    cd build/sdk/tmp
    for i in $(ls *.jar)
    do
        jar -xf $i
    done
    rm *.jar
    rm -rf com/miui/analytics/
    rm -rf com/xiaomi/analytics/
    jar -cf ../MiAdSdkRemote.jar .
    echo
    echo "[SDK PATH] build/sdk/MiAdSdkRemote.jar"
    cd ../; rm -rf tmp
fi
cd $curr
