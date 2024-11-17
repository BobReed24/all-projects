using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms.Other
{
    public static class Geohash
    {
        private const string Base32Characters = "0123456789bcdefghjkmnpqrstuvwxyz"; 
        private const int GeohashLength = 12; 

        public static string Encode(double latitude, double longitude)
        {
            double[] latitudeRange = new[] { -90.0, 90.0 };
            double[] longitudeRange = new[] { -180.0, 180.0 };
            bool isEncodingLongitude = true;
            int currentBit = 0;
            int base32Index = 0;
            StringBuilder geohashResult = new StringBuilder();

            while (geohashResult.Length < GeohashLength)
            {
                double midpoint;

                if (isEncodingLongitude)
                {
                    midpoint = (longitudeRange[0] + longitudeRange[1]) / 2;
                    if (longitude > midpoint)
                    {
                        base32Index |= 1 << (4 - currentBit);
                        longitudeRange[0] = midpoint;
                    }
                    else
                    {
                        longitudeRange[1] = midpoint;
                    }
                }
                else
                {
                    midpoint = (latitudeRange[0] + latitudeRange[1]) / 2;
                    if (latitude > midpoint)
                    {
                        base32Index |= 1 << (4 - currentBit);
                        latitudeRange[0] = midpoint;
                    }
                    else
                    {
                        latitudeRange[1] = midpoint;
                    }
                }

                isEncodingLongitude = !isEncodingLongitude;

                if (currentBit < 4)
                {
                    currentBit++;
                }
                else
                {
                    geohashResult.Append(Base32Characters[base32Index]);
                    currentBit = 0;
                    base32Index = 0;
                }
            }

            return geohashResult.ToString();
        }
    }
}
