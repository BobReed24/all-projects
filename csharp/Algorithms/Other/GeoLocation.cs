using System;

namespace Algorithms.Other;

public static class GeoLocation
{
    private const double EarthRadiusKm = 6371.01d;

    public static double CalculateDistanceFromLatLng(double lat1, double lng1, double lat2, double lng2)
    {
        var pi180 = Math.PI / 180d;
        var lat1Radian = lat1 * pi180;
        var lng1Radian = lng1 * pi180;
        var lat2Radian = lat2 * pi180;
        var lng2Radian = lng2 * pi180;

        var diffLat = lat2Radian - lat1Radian;
        var diffLng = lng2Radian - lng1Radian;

        var haversine =
            Math.Sin(diffLat / 2) * Math.Sin(diffLat / 2)
            + Math.Cos(lat1Radian) * Math.Cos(lat2Radian) * Math.Sin(diffLng / 2) * Math.Sin(diffLng / 2);
        var distance = EarthRadiusKm * (2d * Math.Atan2(Math.Sqrt(haversine), Math.Sqrt(1 - haversine)));

        return distance * 1000; 
    }
}
