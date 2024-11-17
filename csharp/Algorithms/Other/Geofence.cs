using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms.Other
{
    public class Geofence
    {
        public double Latitude { get; set; }

        public double Longitude { get; set; }

        public double RadiusInMeters { get; set; }

        public Geofence(double latitude, double longitude, double radiusInMeters)
        {
            Latitude = latitude;
            Longitude = longitude;
            RadiusInMeters = radiusInMeters;
        }

        public bool IsInside(double userLatitude, double userLongitude)
        {
            double distance = GeoLocation.CalculateDistanceFromLatLng(Latitude, Longitude, userLatitude, userLongitude);
            return distance <= RadiusInMeters;
        }
    }
}
