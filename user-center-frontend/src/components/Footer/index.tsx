import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
const Footer: React.FC = () => {
  const defaultMessage = 'HalcyonJX个人技术出品';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'github',
          title: <GithubOutlined />,
          href: 'https://github.com/HalcyonJX',
          blankTarget: true,
        },
        {
          key: 'HalcyonJX',
          title: '博客预留位',
          href: 'https://github.com/HalcyonJX',
          blankTarget: true,
        },
      ]}
    />
  );
};
export default Footer;
