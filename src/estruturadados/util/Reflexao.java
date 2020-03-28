package estruturadados.util;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

public class Reflexao {

    public static Object readDeclaredField(final Object instancia, final String nomeAtributo) throws IllegalAccessException {

        return FieldUtils.readDeclaredField(instancia, nomeAtributo, true);
    }

    public static Date toDate(final String date) {

        Date localDate = null;
        final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            localDate = format.parse(date);
        } catch (final ParseException e) {
            e.printStackTrace();
        }

        return localDate;
    }

    public static <T> T getInstance(final Class<T> clazz) throws InstantiationException, IllegalAccessException {

        final T instance = clazz.newInstance();

        return instance;

    }

    public static <T> T populaObjeto(final Class<T> clazz) throws InstantiationException, IllegalAccessException {

        final T instance = clazz.newInstance();

        for (final Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            final Object valor = Reflexao.getRandomValueToField(field);
            field.set(instance, valor);
        }

        return instance;

    }

    private static Object getRandomValueToField(final Field field) throws InstantiationException, IllegalAccessException {

        final Random random = new Random();

        final Class<?> tipo = field.getType();

        Object campo = null;

        if (tipo.isEnum()) {
            // final Object[] enumValues = tipo.getEnumConstants();
            // campo = enumValues[random.nextInt(enumValues.length)];
            final int x = random.nextInt(tipo.getEnumConstants().length);
            campo = tipo.getEnumConstants()[x];
        } else if (int.class.isAssignableFrom(tipo)) {
            campo = random.nextInt(60000000);
        } else if (long.class.isAssignableFrom(tipo)) {
            campo = random.nextLong();
        } else if (double.class.isAssignableFrom(tipo)) {
            campo = random.nextDouble();
        } else if (float.class.isAssignableFrom(tipo)) {
            campo = random.nextFloat();
        } else if (String.class.isAssignableFrom(tipo)) {
            final int lenght = 255;
            final boolean lettras = true;
            final boolean numeros = false;

            final String gerarString = RandomStringUtils.random(lenght, lettras, numeros);

            campo = gerarString;
        } else if (tipo.equals(BigInteger.class)) {
            campo = BigInteger.valueOf(random.nextInt());
        } else if (tipo.isAssignableFrom(Boolean.TYPE)) {
            campo = random.nextBoolean();
        } else if (Date.class.isAssignableFrom(tipo)) {
            @SuppressWarnings("deprecation")
            final long start = new Date("01/01/0001").getTime();
            @SuppressWarnings("deprecation")
            final long end = new Date("03/07/2018").getTime();
            final long rand = end + (long) (random.nextDouble() * (start - end));
            final Date resultdate = new Date(rand);
            campo = resultdate;
        }

        return campo;

    }

}