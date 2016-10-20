using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Text.RegularExpressions;

public static class StringExtensions
{
    /// <summary>
    /// Converts to MD5 hash in hexdecimal.
    /// </summary>
    /// <param name="input"></param>
    /// <returns>The <paramref name="input"/> hash as an array of 16 bytes, each in hexdecimal.</returns>
    public static string ToMd5Hash(this string input)
    {
        var md5Hash = MD5.Create();
        var data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(input));
        var builder = new StringBuilder();

        for (int i = 0; i < data.Length; i++)
        {
            builder.Append(data[i].ToString("x2"));
        }
        
        return builder.ToString();
    }

    /// <summary>
    /// Converts <paramref name="input"/> to true.
    /// </summary>
    /// <example> 
    /// The <paramref name="input"/> must be "true", "ok", "yes", "1" or "да" in order to return true.
    /// </example>
    /// <param name="input"></param>
    /// <returns>A boolean indicating wether <paramref name="input"/> matches one of the set "true" string values.</returns>
    /// <remarks>
    /// The <paramref name="input"/> does not need to be lowercase.
    /// </remarks>
    public static bool ToBoolean(this string input)
    {
        var stringTrueValues = new[] { "true", "ok", "yes", "1", "да" };
        return stringTrueValues.Contains(input.ToLower());
    }

    /// <summary>
    /// Converts <paramref name="input"/> to short.
    /// </summary>
    /// <param name="input"></param>
    /// <returns>The <paramref name="input"/> in System.Int16 if able.</returns>
    public static short ToShort(this string input)
    {
        short shortValue;
        short.TryParse(input, out shortValue);
        return shortValue;
    }

    /// <summary>
    /// Converts <paramref name="input"/> to int.
    /// </summary>
    /// <param name="input"></param>
    /// <returns>The <paramref name="input"/> in System.Int32 if able.</returns>
    public static int ToInteger(this string input)
    {
        int integerValue;
        int.TryParse(input, out integerValue);
        return integerValue;
    }

    /// <summary>
    /// Converts <paramref name="input"/> to long.
    /// </summary>
    /// <param name="input"></param>
    /// <returns>The <paramref name="input"/> in System.Int64 if able.</returns>
    public static long ToLong(this string input)
    {
        long longValue;
        long.TryParse(input, out longValue);
        return longValue;
    }

    /// <summary>
    /// Converts <paramref name="input"/> to DateTime.
    /// </summary>
    /// <param name="input"></param>
    /// <returns>The <paramref name="input"/> in System.DateTime if able.</returns>
    public static DateTime ToDateTime(this string input)
    {
        DateTime dateTimeValue;
        DateTime.TryParse(input, out dateTimeValue);
        return dateTimeValue;
    }

    /// <summary>
    /// Capitalizes the first letter of <paramref name="input"/>.
    /// </summary>
    /// <param name="input">
    /// Non-empty, non-null string.
    /// </param>
    /// <returns><paramref name="input"/> with a capitalized first letter</returns>
    public static string CapitalizeFirstLetter(this string input)
    {
        if (string.IsNullOrEmpty(input))
        {
            return input;
        }

        return 
            input.Substring(0, 1).ToUpper(CultureInfo.CurrentCulture) + 
            input.Substring(1, input.Length - 1);
    }

    /// <summary>
    /// Returns the string between <paramref name="startString"/> and <paramref name="endString"/> in <paramref name="input"/>.
    /// Starts the search from position <paramref name="startFrom"/> in <paramref name="input"/>.
    /// </summary>
    /// <param name="input"></param>
    /// <param name="startString"></param>
    /// <param name="endString"></param>
    /// <param name="startFrom"></param>
    /// <returns></returns>
    public static string GetStringBetween(
        this string input, string startString, string endString, int startFrom = 0)
    {
        input = input.Substring(startFrom);
        startFrom = 0;
        if (!input.Contains(startString) || !input.Contains(endString))
        {
            return string.Empty;
        }

        var startPosition = 
            input.IndexOf(startString, startFrom, StringComparison.Ordinal) + startString.Length;
        if (startPosition == -1)
        {
            return string.Empty;
        }

        var endPosition = input.IndexOf(endString, startPosition, StringComparison.Ordinal);
        if (endPosition == -1)
        {
            return string.Empty;
        }

        return input.Substring(startPosition, endPosition - startPosition);
    }

    /// <summary>
    /// Replaces all cyrillic letters in <paramref name="input"/> with their latin counterparts.
    /// </summary>
    /// <param name="input"></param>
    /// <returns><paramref name="input"/> with replacd cyrillic letters.</returns>
    public static string ConvertCyrillicToLatinLetters(this string input)
    {
        var bulgarianLetters = new[]
        {
            "а", "б", "в", "г", "д", "е", "ж", "з", "и", "й", "к", "л", "м", "н", "о",
            "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ь", "ю", "я"
        };
        var latinRepresentationsOfBulgarianLetters = new[]
        {
            "a", "b", "v", "g", "d", "e", "j", "z", "i", "y", "k",
            "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h",
            "c", "ch", "sh", "sht", "u", "i", "yu", "ya"
        };
        for (var i = 0; i < bulgarianLetters.Length; i++)
        {
            input = input.Replace(bulgarianLetters[i], latinRepresentationsOfBulgarianLetters[i]);
            input = input.Replace(bulgarianLetters[i].ToUpper(),
                latinRepresentationsOfBulgarianLetters[i].CapitalizeFirstLetter());
        }

        return input;
    }

    /// <summary>
    /// Replaces all latin letters in <paramref name="input"/> with their cyrillic counterparts.
    /// </summary>
    /// <param name="input"></param>
    /// <returns><paramref name="input"/> with replacd latin letters.</returns>
    public static string ConvertLatinToCyrillicKeyboard(this string input)
    {
        var latinLetters = new[]
        {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
        };

        var bulgarianRepresentationOfLatinKeyboard = new[]
        {
            "а", "б", "ц", "д", "е", "ф", "г", "х", "и", "й", "к",
            "л", "м", "н", "о", "п", "я", "р", "с", "т", "у", "ж",
            "в", "ь", "ъ", "з"
        };

        for (int i = 0; i < latinLetters.Length; i++)
        {
            input = input.Replace(latinLetters[i], bulgarianRepresentationOfLatinKeyboard[i]);
            input = input.Replace(latinLetters[i].ToUpper(),
                bulgarianRepresentationOfLatinKeyboard[i].ToUpper());
        }

        return input;
    }

    /// <summary>
    /// Converts <paramref name="input"/> to a valid username.
    /// </summary>
    /// <example>
    /// "готхика_47$$$" will return "gothika_47".
    /// </example>
    /// <param name="input"></param>
    /// <returns><paramref name="input"/> with replaced cyrillic letters and/or unknown symbols.</returns>
    public static string ToValidUsername(this string input)
    {
        input = input.ConvertCyrillicToLatinLetters();
        return Regex.Replace(input, @"[^a-zA-z0-9_\.]+", string.Empty);
    }

    /// <summary>
    /// Converts <paramref name="input"/> to a valid latin filename.
    /// </summary>
    /// <example>
    /// "домашна работа - не пипай" will return "domashna-rabota---ne-pipaj".
    /// </example>
    /// <param name="input"></param>
    /// <returns><paramref name="input"/> with replaced cyrillic letters, whitespaces and/or unknown symbols.</returns>
    public static string ToValidLatinFileName(this string input)
    {
        input = input.Replace(" ", "-").ConvertCyrillicToLatinLetters();
        return Regex.Replace(input, @"[^a-zA-z0-9_\.\-]+", string.Empty);
    }

    /// <summary>
    /// Get the first n characters.
    /// </summary>
    /// <param name="input"></param>
    /// <param name="charsCount"></param>
    /// <returns>The first <paramref name="charsCount"/> characters or the <paramref name="input"/> itself.</returns>
    /// <remarks>
    /// If <paramref name="charsCount"/> > <paramref name="input"/>.Length, returns <paramref name="input"/>.
    /// </remarks>
    public static string GetFirstCharacters(this string input, int charsCount)
    {
        return input.Substring(0, Math.Min(input.Length, charsCount));
    }

    /// <summary>
    /// Finds the file extension.
    /// </summary>
    /// <param name="fileName"></param>
    /// <example>
    /// Returns ".png" when <paramref name="fileName"/> == "...talos_avatar.png".
    /// Returns "" when <paramref name="fileName"/> == .....png
    /// </example>
    /// <returns>The file extension of <paramref name="fileName"/>. Returns string.Empty if <paramref name="fileName"/> is invalid</returns>
    public static string GetFileExtension(this string fileName)
    {
        if (string.IsNullOrWhiteSpace(fileName))
        {
            return string.Empty;
        }

        string[] fileParts = fileName.Split(new[] { "." }, StringSplitOptions.None);
        if (fileParts.Count() == 1 || string.IsNullOrEmpty(fileParts.Last()))
        {
            return string.Empty;
        }

        return fileParts.Last().Trim().ToLower();
    }

    /// <summary>
    /// Returns the content type represented by the <paramref name="fileExtension"/> value.
    /// </summary>
    /// <param name="fileExtension"></param>
    /// <remarks>
    /// Returns "application/octet-stream" by default.
    /// </remarks>
    public static string ToContentType(this string fileExtension)
    {
        var fileExtensionToContentType = new Dictionary<string, string>
        {
            { "jpg", "image/jpeg" },
            { "jpeg", "image/jpeg" },
            { "png", "image/x-png" },
            { "docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document" },
            { "doc", "application/msword" },
            { "pdf", "application/pdf" },
            { "txt", "text/plain" },
            { "rtf", "application/rtf" }
        };
        if (fileExtensionToContentType.ContainsKey(fileExtension.Trim()))
        {
            return fileExtensionToContentType[fileExtension.Trim()];
        }

        return "application/octet-stream";
    }

    /// <summary>
    /// Converts <paramref name="input"/> to byte array.
    /// </summary>
    /// <param name="input"></param>
    /// <returns><paramref name="input"/> represented as a byte array.</returns>
    public static byte[] ToByteArray(this string input)
    {
        var bytesArray = new byte[input.Length * sizeof(char)];
        Buffer.BlockCopy(input.ToCharArray(), 0, bytesArray, 0, bytesArray.Length);
        return bytesArray;
    }
}
