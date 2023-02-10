package com.epam.rd.autocode.floodfill;

public class FloodIml implements FloodFill{

    private final static char X = 'X';

    @Override
    public void flood(String map, FloodLogger logger) {

        logger.log(map);

        if (!map.contains(String.valueOf(LAND))) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int len = map.indexOf('\n');

        char[] mapChars = map.toCharArray();
        for (int i = 0; i < mapChars.length; i++) {
            if (mapChars[i] == WATER) {
                if (i + 1 < mapChars.length && mapChars[i + 1] != '\n' && mapChars[i + 1] != WATER) {
                    mapChars[i + 1] = X;
                }
                if (i - 1 >= 0 && mapChars[i - 1] != '\n' && mapChars[i - 1] != WATER) {
                    mapChars[i - 1] = X;
                }
                if (i + len + 1 < mapChars.length && mapChars[i + len + 1] != WATER) {
                    mapChars[i + len + 1] = X;
                }

                if (i - len - 1 >= 0 && mapChars[i - len - 1] != WATER) {
                    mapChars[i - len - 1] = X;
                }
            }
        }
        stringBuilder.append(mapChars);

        map = stringBuilder.toString().replaceAll(String.valueOf(X), String.valueOf(WATER));

        flood(map, logger);
    }
}

