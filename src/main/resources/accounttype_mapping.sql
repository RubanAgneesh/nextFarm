/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::                                                                         :*/
/*::  This routine calculates the distance between two points (given the     :*/
/*::  latitude/longitude of those points). It is being used to calculate     :*/
/*::  the distance between two locations using GeoDataSource(TM) Products    :*/
/*::                                                                         :*/
/*::  Definitions:                                                           :*/
/*::    South latitudes are negative, east longitudes are positive           :*/
/*::                                                                         :*/
/*::  Passed to function:                                                    :*/
/*::    lat1, lon1 = Latitude and Longitude of point 1 (in decimal degrees)  :*/
/*::    lat2, lon2 = Latitude and Longitude of point 2 (in decimal degrees)  :*/
/*::    unit = the unit you desire for results                               :*/
/*::           where: 'M' is statute miles (default)                         :*/
/*::                  'K' is kilometers                                      :*/
/*::                  'N' is nautical miles                                  :*/
/*::                                                                         :*/
/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/

CREATE OR REPLACE FUNCTION def_account_mapping
(
    c_id bigint
)  
RETURNS bigint
LANGUAGE plpgsql      
AS   
$$  
declare
v_account_id bigint;
begin
INSERT INTO ACCOUNT_MAPPING(ACCOUNTS_ID,COMPANY_ID)
SELECT ACCOUNTS.ID AS ACCOUNTS_ID,COMPANY.ID AS COMPANY_ID FROM ACCOUNTS,COMPANY
WHERE COMPANY.ID=c_id AND ACCOUNTS.ID <= 27;
return v_account_id;

end;
$$;