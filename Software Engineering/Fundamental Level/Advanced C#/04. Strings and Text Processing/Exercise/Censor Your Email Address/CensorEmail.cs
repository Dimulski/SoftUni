// You have some text that contains your email address. You’re sick of spammers, so you want to hide it. You decide to
// replace all characters in it with asterisks ('*') except the domain. Assume the email address will always be in
// format [username]@[domain]; you’ll need to replace username with asterisks of equal length and keep the domain unchanged. 

using System;

namespace Censor_Your_Email_Address
{
    class CensorEmail
    {
        static void Main()
        {
            // Email edit
            string email = Console.ReadLine();
            string substring = email.Substring(0, email.LastIndexOf('@'));
            substring = new string('*', substring.Length);
            string censoredEmail = substring + email.Substring(email.LastIndexOf('@'));
            
            // Reading message and replacing email
            string[] message = Console.ReadLine().Split(' ');
            for (int i = 0; i < message.Length; i++)
            {
                if (message[i] == email)
                {
                    message[i] = censoredEmail;
                }
            }

            // Printing new message
            for (int i = 0; i < message.Length; i++)
            {
                Console.Write(message[i] + " ");
            }
        }
    }
}
