import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import {GITHUB_LINK} from "@/constant";
const Footer: React.FC = () => {
  const defaultMessage = '天地一家大爱盟出品';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'github',
          title:<> <GithubOutlined /> GitHub项目地址</>,
          href: GITHUB_LINK,
          blankTarget: true,
        },
        {
          key: 'HalcyonJX',
          title: '博客预留位',
          href: GITHUB_LINK,
          blankTarget: true,
        },
      ]}
    />
  );
};
export default Footer;
