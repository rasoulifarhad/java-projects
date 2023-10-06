package com.farhad.example.functional_interface.separating_concerns_lambda.iterations.Iteration1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.farhad.example.functional_interface.separating_concerns_lambda.iterations.Iteration1.Asset.AssetType;

public class AssetUtilRefactored {
    
    static final List<Asset> assets = Arrays.asList(
        new Asset(AssetType.BOND, 1000),
        new Asset(AssetType.BOND, 2000),
        new Asset(AssetType.STOCK, 3000),
        new Asset(AssetType.STOCK, 4000)); 

    private AssetUtilRefactored(){}

    public static int totalAssetValues(
                List<Asset> assets,
                Predicate<Asset> assetSelector) {
        return assets.stream()
                    .filter(assetSelector)            
                    .mapToInt(Asset::getValue)
                    .sum();
    }

    public static void main(String[] args) {

        System.out.println("Total of all assets: " + 
                totalAssetValues(assets, asset -> true ));   

        System.out.println("Total of bond assets: " + 
                totalAssetValues(assets, asset -> asset.getType() == AssetType.BOND ));   

        System.out.println("Total of stock assets: " + 
                totalAssetValues(assets, asset -> asset.getType() == AssetType.STOCK ));   
    }

}
