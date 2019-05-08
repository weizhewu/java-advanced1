package single;


import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * 第一次个人大作业，仿制文本文档
 * @author 位哲武
 * 2019/4/24---------2019/4/27
 */

/**
 *top11新建功能的实现，弹出窗口
 *top12目前写死了打开的目录，没有使用输入框
 *top14另存为功能的实现
 *top17退出功能
 *top21撤销的功能实现
 *top23复制
 *top24粘贴
 *top26使用Bing搜索
 *top212查看时间日期
 *top51查看帮助,使用网络爬虫
 *top52帮助功能的实现，只是弹出一个String的对话框
 * 右侧进度条
 * 下方文字轮播
 * 子窗口实现渐变色和账号密码登录
 *
 */
public class SecondBigTask extends JFrame implements ActionListener {
    private JMenu top1,top2,top3,top4,top5;
    private JMenuItem top11,top12,top13,top14,top15,top16,top17;
    private JMenuItem top21,top22,top23,top24,top25,top26,top27,top28,top29,top210,top211,top212;
    private JMenuItem top31,top32;
    private JMenuItem top41,top42;
    private JMenuItem top51,top52;
    private CardLayout cardLayout;
    private JPanel leftPanel;
    private ShadePanel rightPanel;
    private JTextArea contentArea;
    private File nowFile;
    private JLabel wordLabel;
    private StringSelection stringSelection;

    public SecondBigTask(){
        init();
        setTitle("个人大作业.txt - 记事本");
        setBounds(650, 350, 665, 445);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //进度条
        JScrollBar progressBar = new JScrollBar();
        progressBar.setVisible(true);
        getContentPane().add(progressBar,BorderLayout.EAST);
        for (int i = 0;i <=100;i++){
            progressBar.setValue(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void setContentArea(JTextArea contentArea) {
        this.contentArea = contentArea;
    }

    public void setWordLabel(JLabel wordLabel) {
        this.wordLabel = wordLabel;
    }

    public void init(){
        JSplitPane pane = new JSplitPane();
        leftPanel = new JPanel();
        cardLayout = new CardLayout();
        leftPanel.setLayout(cardLayout);
        contentArea = new JTextArea();
        rightPanel = new ShadePanel();
        rightPanel.add(contentArea);
        pane.setLeftComponent(leftPanel);
        pane.setRightComponent(rightPanel);
        pane.setDividerLocation(0.5);
        add(pane,BorderLayout.CENTER);

        Font font = new Font("微软雅黑", Font.PLAIN, 18);
        wordLabel = new JLabel();
        wordLabel.setFont(font);
        add(wordLabel,BorderLayout.SOUTH);
        WordThread wt = new WordThread();
        wt.setWordLabel(wordLabel);
        new Thread(wt).start();


        //添加窗口事件处理程序，使用适配器
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(-1);
            }
        });

        //顶部菜单
        top1 = new JMenu("文件(F)");
        top2 = new JMenu("编辑(E)");
        top3 = new JMenu("格式(O)");
        top4 = new JMenu("查看(V)");
        top5 = new JMenu("帮助(H)");
        JMenuBar top = new JMenuBar();
        top.add(top1);
        top.add(top2);
        top.add(top3);
        top.add(top4);
        top.add(top5);
        add(top, BorderLayout.NORTH);

        //文件(F)的组件
        top11 = new JMenuItem("新建(N)");
        top11.addActionListener(this);
        top12 = new JMenuItem("打开(O)...");
        top12.addActionListener(this);
        top13 = new JMenuItem("保存(S)");
        top14 = new JMenuItem("另存为(A)...");
        top14.addActionListener(this);
        top15 = new JMenuItem("页面设置(U)...");
        top16 = new JMenuItem("打印(P)...");
        top16.addActionListener(this);
        top17 = new JMenuItem("退出(X)");
        top17.addActionListener(this);
        top1.add(top11);
        top1.add(top12);
        top1.add(top13);
        top1.add(top14);
        top1.add(top15);
        top1.add(top16);
        top1.add(top17);

        //编辑(E)的组件
        top21 = new JMenuItem("撤销(U)");
        top21.addActionListener(this);
        top22 = new JMenuItem("剪切(T)");
        top23 = new JMenuItem("复制(C)");
        top23.addActionListener(this);
        top24 = new JMenuItem("粘贴(P)");
        top24.addActionListener(this);
        top25 = new JMenuItem("删除(L)");
        top26 = new JMenuItem("使用Bing搜索");
        top26.addActionListener(this);
        top27 = new JMenuItem("查找(F)...");
        top28 = new JMenuItem("查找下一个(V)");
        top29 = new JMenuItem("替换(R)...");
        top210 = new JMenuItem("转到(G)...");
        top211 = new JMenuItem("全选(A)");
        top211.addActionListener(this);
        top212 = new JMenuItem("时间/日期(D)");
        top212.addActionListener(this);
        top2.add(top21);
        top2.add(top22);
        top2.add(top23);
        top2.add(top24);
        top2.add(top25);
        top2.add(top26);
        top2.add(top27);
        top2.add(top28);
        top2.add(top29);
        top2.add(top210);
        top2.add(top211);
        top2.add(top212);

        //格式(D)的组件
        top31 = new JMenuItem("自动换行(W)");
        top32 = new JMenuItem("字体(F)...");
        top3.add(top31);
        top3.add(top32);

        //查看(V)的组件
        top41 = new JMenuItem("缩放(Z)");
        top42 = new JMenuItem("状态栏(S)");
        top4.add(top41);
        top4.add(top42);

        //帮助(H)的组件
        top51 = new JMenuItem("查看帮助(H)");
        top51.addActionListener(this);
        top52 = new JMenuItem("关于记事本(A)");
        top52.addActionListener(this);
        top5.add(top51);
        top5.add(top52);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new SecondBigTask();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //获得系统剪切板
        Clipboard clipboard=java.awt.Toolkit.
                getDefaultToolkit().getSystemClipboard();
        //新建功能的实现，弹出窗口
        if (e.getSource() == top11){
            Top11TestThread td11 = new Top11TestThread();
            new Thread(td11).start();
        }
        //目前写死了打开的目录，没有使用输入框
        if (e.getSource() == top12){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setCurrentDirectory(new File("D:\\img1"));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File[] files = fileChooser.getSelectedFiles();
                for (File f : files){
                    try {
                        byte[] bytes = new byte[(int) f.length()];
                        InputStream inputStream = new FileInputStream(f);
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imgLabel = new JLabel();
                        imgLabel.setIcon(icon);
                        imgLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                cardLayout.next(leftPanel);
                            }
                        });
                        leftPanel.add(imgLabel);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null,"IO操作异常");
                    }
                }
            }
        }
        //另存为功能的实现
        if (e.getSource() == top14){
            FileWriter writer = null;
            try {
                FileDialog dialog = new FileDialog(this, "保存位置", FileDialog.SAVE);
                dialog.setVisible(true);
                nowFile = new File(dialog.getDirectory(), dialog.getFile());
                writer = new FileWriter(nowFile);
                writer.write(contentArea.getText());

            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            rightPanel.setVisible(false);
        }
        //打印功能播放音乐
        if (e.getSource() == top16){
            Top16Thread td16 = new Top16Thread();
            new Thread(td16).start();
        }
        //退出功能
        if (e.getSource() == top17){
            this.dispose();

        }
        //撤销的功能实现
        if (e.getSource() == top21){
            //调用previous显示上一张
            cardLayout.previous(leftPanel);
        }
        //剪切功能未实现
        if (e.getSource() == top22){
            contentArea.cut();
            // StringSelectiontext=newStringSelection(temp);
            // clipboard.setContents(text,null);
            // intstart=text1.getSelectionStart();
            // intend=text1.getSelectionEnd();
            // text1.replaceRange("",start,end);//从Text1中删除被选取的文本。
            //Toolkit.getDefaultToolkit().getSystemClipboard();
        }
        //复制功能
        if (e.getSource() == top23 ){
            String temp=contentArea.getSelectedText();
            stringSelection=new StringSelection(temp);
            clipboard.setContents(stringSelection,null);
        }
        //粘贴功能,主要是从系统剪切板里取得数据
        if (e.getSource() == top24){
            java.awt.datatransfer.Transferable transferable=clipboard.getContents(this);
            java.awt.datatransfer.DataFlavor flavor=java.awt.datatransfer.DataFlavor.stringFlavor;
            if(transferable.isDataFlavorSupported(flavor))
            {
                try
                {
                    int start=contentArea.getSelectionStart();
                    int end=contentArea.getSelectionEnd();
                    contentArea.replaceRange("",start,end);
                    String str;
                    int n=contentArea.getCaretPosition();
                    str=(String)transferable.getTransferData(flavor);
                    contentArea.insert(str,n);
                }
                catch(Exception ee)
                {
                }
            }
        }
        //使用Bing搜索
        if (e.getSource() == top26){
            Top26Thread td26 = new Top26Thread();
            new Thread(td26).start();
        }
        //全选功能,未实现
        if (e.getSource() == top211){
            contentArea.selectAll();
        }
        //查看时间日期
        if (e.getSource() == top212){
            Top212Thread td212 = new Top212Thread();
            new Thread(td212).start();

        }
        //查看帮助,使用网络爬虫
        if (e.getSource() == top51){
            try {
                Top51Thread td51 = new Top51Thread();
                new Thread(td51).start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        //帮助功能的实现，只是弹出一个String的对话框
        if (e.getSource() == top52){
            Top52Thread td52 = new Top52Thread();
            new Thread(td52).start();
        }
    }
}
class Top11TestThread extends JFrame implements Runnable{
    private JLabel accountLabel, passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton confirmButton, cancelButton;
    public Top11TestThread(){
        init();
        setTitle("登录界面");
        setSize(665, 445);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 400);
        Font font = new Font("仿宋", Font.PLAIN, 30);
        accountLabel = new JLabel("账号:");
        accountLabel.setFont(font);
        accountLabel.setForeground(new Color(4, 4, 4));
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(new Color(4, 4, 4));
        passwordField = new JPasswordField();
        passwordField.setFont(font);

        confirmButton = new JButton("确认");
        confirmButton.setFont(font);
        cancelButton = new JButton("取消");
        cancelButton.setFont(font);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText().trim();
                String password = String.valueOf(passwordField.getPassword());
                if ("weizhewu".equals(account) && "20190426".equals(password)) {
                    //关闭登录
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //打开主体线程
                    Top11Thread top11Thread = new Top11Thread();
                    new Thread(top11Thread).start();
                }
            }
        });
        accountLabel.setBounds(60, 150, 100, 35);
        accountField.setBounds(200, 150, 260, 35);
        passwordLabel.setBounds(60, 220, 100, 35);
        passwordField.setBounds(200, 220, 260, 35);
        confirmButton.setBounds(100,300,100,35);
        cancelButton.setBounds(280,300,100,35);
        panel.add(accountLabel);
        panel.add(accountField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmButton);
        panel.add(cancelButton);
        add(panel);
    }

    public static void main(String[] args) {
        new Top11TestThread();
    }

    @Override
    public void run() {

    }
}
class Top11Thread extends JFrame implements Runnable {
     public Top11Thread(){
        init();
        setTitle("新建窗口");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(350, 350, 665, 445);
    }
    public void init(){
        ShadePanel shadePanel = new ShadePanel();
        add(shadePanel);

    }
    @Override
    public void run() {

    }
    class ShadePanel extends JPanel {
        public ShadePanel(){
            java.util.Timer timer = new Timer();
            timer.schedule(timerTask,0,2000);

        }
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        };
        @Override
        protected void paintComponent(Graphics g2) {
            Graphics2D g = (Graphics2D) g2;
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();
            Color[] color = {Color.CYAN,Color.MAGENTA,Color.pink,Color.orange};
            Random r = new Random();
            int i = r.nextInt(2);
            int j = r.nextInt(3);
            //创建填充模式对象
            GradientPaint paint = new GradientPaint(i, j, color[i], 0, height,color[j]);
            g.setPaint(paint);
            g.fillRect(i, j, width, height);
        }
    }
    public static void main(String[] args) {
        new Top11Thread();
    }
}
class Top16Thread extends Thread{
    @Override
    public void run() {
        URL url;
        File file = new File("D:/1.wav");
        int i = 1;
        while (i >= 1) {
            try {
                url = file.toURI().toURL();
                AudioClip audioClip = Applet.newAudioClip(url);
                audioClip.play();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            i--;
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Top26Thread extends Thread {
    Desktop desktop = Desktop.getDesktop();
    URI uri; //创建URI统一资源标识符
    {
        try {
            uri = new URI("http://www.baidu.com");
            desktop.browse(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Top212Thread extends JFrame implements Runnable {
    private JLabel timeLabel;
    private TimerTask timerTask;
    public Top212Thread(){
        init();
        setTitle("时间窗口");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(350, 350, 310, 130);
    }
    public void init(){
    }
    @Override
    public void run() {
        Font font = new Font("微软雅黑",Font.BOLD,20);
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        timerTask = new TimerTask() {
            @Override
            public void run() {
                while (true){
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date currentTime = new Date();
                    String a = format.format(currentTime);
                    timeLabel.setText(a);
                    add(timeLabel,BorderLayout.SOUTH);
                }
            }
        } ;
        Timer timer = new Timer();
        timer.schedule(timerTask,0,1000);
        add(timeLabel,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new Top212Thread();
    }
}
class Top51Thread extends JFrame implements Runnable{
    private JTextArea textArea;
    public Top51Thread() throws IOException {
        init();
        setTitle("新建窗口");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(350, 350, 665, 445);
    }
    public void init() throws IOException {
        //1,指定目标页面链接
        String url = "https://baike.baidu.com/item/%E8%AE%B0%E4%BA%8B%E6%9C%AC/2519?fr=aladdin";
        //2,建立目标页面链接
        Connection connection = Jsoup.connect(url);
        //3,解析目标页面
        Document document = connection.get();
        //4,获取页面中所有的class为content的元素，本例在页面中可以检查元素，是div
        Elements elements = document.getElementsByClass("lemma-summary");
//        System.out.println(elements.size());
        for (Element element : elements) {
            Element link = element;
            //得到a标记的文字内容
            String titleString = link.text();
            textArea = new JTextArea(titleString);
        }
        JScrollPane jScrollPane = new JScrollPane(textArea);
        add(jScrollPane);
    }
    @Override
    public void run() {

    }

    public static void main(String[] args) throws IOException {
        new Top51Thread();
    }
}
class Top52Thread extends Thread{
    Object[] possibleValues = { "不会", "没做", "学习中" };
    Object selectedValue = JOptionPane.showInputDialog(
            null, "此功能尚未完成",
            "新建弹出的窗口",
            JOptionPane.INFORMATION_MESSAGE, null,
            possibleValues, possibleValues[0]);
}
class WordThread extends Thread {
    private JLabel wordLabel;
    private String[]word = {"时间是一切财富中最宝贵的财富。 ",
            "把时间用在思考上是最能节省时间的事情。",
            "真理惟一可靠的标准就是永远自相符合。 ",
            "生活有度，人生添寿。 —— 书摘",
            "从不浪费时间的人没有工夫抱怨时间不够。 ",
            "行万里路，读万卷书",
            "学习永远不晚",
            "事常与人违，事总在人为",
            "行路人，用足音代替叹息吧",
            "鞋底磨穿了，不等于路走到了头"};
    public void setWordLabel(JLabel wordLabel) {
        this.wordLabel = wordLabel;
    }
    @Override
    public void run() {
        int i = 0;
        int len = word.length;
        while (true){
            wordLabel.setText(word[i]);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i == len) {
                i = 0;
            }
        }
    }
}
class ShadePanel extends JPanel {
    public ShadePanel(){
        java.util.Timer timer = new Timer();
        timer.schedule(timerTask,0,2000);

    }
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            repaint();
        }
    };
    @Override
    protected void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Color[] color = {Color.CYAN,Color.MAGENTA,Color.pink,Color.orange};
        Random r = new Random();
        int i = r.nextInt(2);
        int j = r.nextInt(3);
        //创建填充模式对象
        GradientPaint paint = new GradientPaint(i, j, color[i], 0, height,color[j]);
        g.setPaint(paint);
        g.fillRect(i, j, width, height);
    }
}

