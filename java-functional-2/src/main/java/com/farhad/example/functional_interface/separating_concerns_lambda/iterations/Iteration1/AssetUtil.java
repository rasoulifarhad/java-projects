package com.farhad.example.functional_interface.separating_concerns_lambda.iterations.Iteration1;

import java.util.Arrays;
import java.util.List;

import com.farhad.example.functional_interface.separating_concerns_lambda.iterations.Iteration1.Asset.AssetType;

public class AssetUtil {
    
    static final List<Asset> assets = Arrays.asList(
        new Asset(AssetType.BOND, 1000),
        new Asset(AssetType.BOND, 2000),
        new Asset(AssetType.STOCK, 3000),
        new Asset(AssetType.STOCK, 4000));

    private AssetUtil() {}
    
    public static int totalAssetValues(List<Asset> assets) {
        return assets.stream()
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Total of all assets: " + totalAssetValues(assets));        
    }
}
