using System;
using System.Collections.Generic;
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

namespace ColorRGB
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public static void rellenarComboBox(ComboBox combo)
        {
            for (int i = 0; i <= 255; i++)
            {
                combo.Items.Add(i);
            }
        }

        private void btnPintar_Click(object sender, RoutedEventArgs e)
        {
            byte r = (byte)comboRojo.SelectedIndex;
            byte g = (byte)comboVerde.SelectedIndex;
            byte b = (byte)comboAzul.SelectedIndex; 

            Color color = Color.FromRgb(r, g, b);
            SolidColorBrush brush = new SolidColorBrush(color);

            btnPintar.Background = brush;
        }
        public MainWindow()
        {
            InitializeComponent();
            rellenarComboBox(comboRojo);
            rellenarComboBox(comboVerde);
            rellenarComboBox(comboAzul);
        }
    }
}
