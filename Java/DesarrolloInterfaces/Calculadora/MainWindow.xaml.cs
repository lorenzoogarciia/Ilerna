using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Calculadora
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private void Button_Click(object sender, RoutedEventArgs e) { 
        
            Button button = sender as Button; //Obtiene el botón que ha sido clickado
            string content = button.Content.ToString(); //obtiene el contenido del boton
            switch (content)
            {
                case "C":
                    display.Text = "0"; break; //Reinicia el valor en el display

                case "=":
                    //Realiza el calculo y actualiza el valor en el display
                    string expression = display.Text;
                    double result = Calculate(expression);
                    display.Text = result.ToString(); break;

                default:
                    //Agrega el numero u operador al final del valor en el display
                    if(display.Text == "0")
                    {
                        display.Text = content;
                    }
                    else
                    {
                        display.Text += content;
                    }
                    break;
            }
        }

        private double Calculate(string expression)
        {
            DataTable table = new DataTable();
            var result = table.Compute(expression, "");
            return Convert.ToDouble(result);
        }
        public MainWindow()
        {
            InitializeComponent();
        }
    }
}
