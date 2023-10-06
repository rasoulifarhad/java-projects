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

    public static int totalBondValues(List<Asset> assets) {
        return assets.stream()
                .mapToInt(asset -> 
                    asset.getType() == AssetType.BOND
                            ? asset.getValue()
                            : 0)
                .sum();
    }

    public static int totalBondValuesBetter(List<Asset> assets) {
        return assets.stream()
                .filter(asset -> asset.getType() == AssetType.BOND)
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int totalStockValues(List<Asset> assets) {
        return assets.stream()
                .mapToInt(asset -> 
                    asset.getType() == AssetType.STOCK
                            ? asset.getValue()
                            : 0)
                .sum();
    }

    public static int totalStockValuesBetter(List<Asset> assets) {
        return assets.stream()
                .filter(asset -> asset.getType() == AssetType.STOCK)
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Total of all assets: " + totalAssetValues(assets));   
        System.out.println("Total of bond assets: " + totalBondValues(assets));        
        System.out.println("Total of bond assets: " + totalBondValuesBetter(assets));        
        System.out.println("Total of stock assets: " + totalStockValues(assets));        
        System.out.println("Total of stock assets: " + totalStockValuesBetter(assets));        

    }
}
